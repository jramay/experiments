mainApp.service("dataService", function($http) {
	
	var baseUrl = "http://localhost:8080/services/rest";
	
	this.getMessage = function(name){
		 return $http.get(baseUrl+'/hello.json?name='+name);
	}
})