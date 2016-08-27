angular
	.module('easytripAPI.plans')
	.controller('PlansController', [ '$http', function($http) {
		var vm = this;

		vm.formData = {};
		vm.formData = {
				latitudeLongitude: "41.396985, 2.148277",
				near : "Barcelona",
				placeDate : new Date()};
		
		vm.submit = function(){
 	        
	        var res = $http.post('http://localhost:8080/easytripAPI/rest/plans/venues', JSON.stringify(vm.formData));
			
			res.success(function(data, status, headers, config) {
				vm.plansData = data;
			});

			res.error(function(data, status, headers, config) {
				console.log("AJAX failed to get data, status=" + status);
      		});
		}
	}]);