mainApp.controller('mainController', function($scope, dataService) {
	
	$scope.getMessage = function() {		
		dataService.getMessage($scope.name).
	    success(function(data) {
	      $scope.message = data.message;
	    }).
	    error(function(data, status, headers, config) {
	      // log error
	    });
	  };
});