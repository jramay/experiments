mainApp.controller('mainController', function($scope, $http) {
	
	$scope.getMessage = function() {		
		$http.get('http://localhost:8080/services/rest/hello.json?name='+$scope.name).
	    success(function(data, status, headers, config) {
	      $scope.message = data.message;
	    }).
	    error(function(data, status, headers, config) {
	      // log error
	    });
	  };
});