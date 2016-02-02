mainApp.controller('mainController', function($scope, $log, dataService) {

	$scope.getMessage = function(isValid) {
		//Check is name is valid
		$log.info('isValid = '+isValid);
		if(!isValid){
			
			return
		}
		
		dataService.getMessage($scope.name).success(function(data) {
			$scope.message = data.message;
			$log.info('Got Response ' + JSON.stringify(data));
		}).error(function(data, status, headers, config) {
			$log.error('Got Error');
		});
	};
});