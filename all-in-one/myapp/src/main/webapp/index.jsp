<html>
<head>

<link rel="stylesheet" type="text/css"
	href="assets/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="assets/css/bootstrap-theme.min.css">
	<link rel="stylesheet" type="text/css"
	href="assets/css/spin.css">
<script src="assets/lib/angular.js"></script>
<script
	src="//ajax.googleapis.com/ajax/libs/angularjs/1.4.9/angular-messages.js"></script>

<script src="mainApp/common/customValidators.js"></script>
<script src="mainApp/mainApp.js"></script>
<script src="mainApp/common/dataService.js"></script>
<script src="mainApp/mainController.js"></script>
<title>AngularJS First Application</title>
</head>

<body>


	<div ng-app="mainApp">
		<form name="mainForm" class="form-horizontal"
			ng-submit="mainForm.$valid && getMessage(mainForm.$valid)"
			ng-controller="mainController" novalidate>
			<h3>My Application</h3>
			<br>
			<br>
			<div class="form-group has-feedback" ng-class="{ 'has-error': mainForm.name.$invalid && mainForm.name.$dirty, 'has-success' :  mainForm.name.$valid, 'has-warning' :  mainForm.name.$pending}">
				<label class="control-label col-xs-2">Name:</label>
				<button class="btn btn-sm btn-primary" ng-click="getMessage(mainForm.$valid)" ng-disabled="mainForm.$invalid || mainForm.$pending">Get Message</button>
				<div class="col-xs-3">
					<input class="form-control" name="name" id="name" type="text" ng-model="name"
						placeholder="Enter name" required ng-minlength="3"
						ng-maxlength="20" username="getUserNames()" ng-model-options="{ updateOn: 'default blur', debounce: { default: 500, blur: 0 } }">
						<span ng-show="mainForm.name.$dirty || mainForm.name.$touched || mainForm.$submitted" ng-class="{'glyphicon-ok': mainForm.name.$valid, 'glyphicon-remove': mainForm.name.$invalid, 'glyphicon-refresh spin': mainForm.name.$pending}" class="glyphicon form-control-feedback" id="name1"></span>
					<div ng-messages="mainForm.name.$error" ng-show="mainForm.name.$dirty || mainForm.name.$touched || mainForm.$submitted">
						<p ng-message="minlength">Your name is too short.</p>
						<p ng-message="maxlength">Your name is too long.</p>
						<p ng-message="required">Your name is required.</p>
						<p ng-message="username">This user name is already taken.</p>
					</div>
					<div ng-messages="mainForm.name.$pending" ng-show="mainForm.name.$dirty || mainForm.name.$touched || mainForm.$submitted">
						<p ng-message="username">Validating user name.</p>
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="col-xs-offset-2 col-xs-10">
					<p class="lead">Message : {{message}}</p>
				</div>
			</div>
		</form>
	</div>
	</div>
</body>
</html>