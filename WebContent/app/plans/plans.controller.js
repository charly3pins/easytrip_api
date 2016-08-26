angular
	.module('easytripAPI.plans')
	.controller('PlansController', [ '$http', function($http) {
		var vm = this;

		vm.placedate =  new Date();

		vm.submit = function(){
			$http.get('http://localhost:8080/easytripAPI/rest/plans/barcelona')
			.success(function(data){
				vm.plansData = data;
				console.log("Results " + vm.plansData);
	    	})
	    	.error(function(data, status, headers, config) {
      			console.log("AJAX failed to get data, status=" + status);
      		});
		}
	}]);