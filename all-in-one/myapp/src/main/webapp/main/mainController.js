mainApp.controller('mainController', function($scope, $log, dataService) {

	$scope.getMessage = function() {
		dataService.getMessage($scope.name).success(function(data) {
			$scope.message = data.message;
			$log.info('Got Response ' + JSON.stringify(data));
		}).error(function(data, status, headers, config) {
			$log.error('Got Error');
		});
	};
});