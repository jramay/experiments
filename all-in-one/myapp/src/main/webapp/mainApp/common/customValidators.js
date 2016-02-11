var customValidators = angular.module("customValidators", []);

customValidators.directive('username', function($q, $timeout) {
	  return {
		    require: 'ngModel',
		    restrict: 'A',
		    scope: {
	            getUserNames : '&username',
	        },
		    link: function(scope, elm, attrs, ctrl) {

		    	var invalidNamesArray = scope.getUserNames();
		    	
		    	ctrl.$asyncValidators.username = function(modelValue, viewValue) {

		        if (ctrl.$isEmpty(modelValue)) {
		          // consider empty model valid
		          return $q.when();
		        }

		        var def = $q.defer();

		        $timeout(function() {
		          // Mock a delayed response
		          if (!invalidNamesArray || invalidNamesArray.indexOf(modelValue) === -1) {
		            // The username is available
		            def.resolve();
		          } else {
		            def.reject();
		          }

		        }, 2000);

		        return def.promise;
		      };
		    }
		  };
		});