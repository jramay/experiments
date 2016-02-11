mainApp.controller('mainController', function($scope, $log, dataService) {

	$scope.usernames = [];
	$scope.getUserNames = function(){
		return $scope.usernames;
	};
	$scope.getMessage = function(isValid) {
		//Check is name is valid
		$log.info('isValid = '+isValid);
		if(!isValid){
			
			return
		}
		
		dataService.getMessage($scope.name).success(function(data) {
			$scope.message = data.message;
			$log.info('Got Response ' + JSON.stringify(data));
			$scope.usernames.push($scope.name)
		}).error(function(data, status, headers, config) {
			$log.error('Got Error');
		});
	};
});