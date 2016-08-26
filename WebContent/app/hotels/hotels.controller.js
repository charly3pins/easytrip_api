angular
	.module('easytripAPI.hotels')
	.controller('HotelsController', [ '$http', function($http) {
		var vm = this;

		vm.formData = {};
		vm.formData = {
				apiKey : "prtl6749387986743898559646983194",
				market : "ES",
				currency : "EUR", 
				locale : "es-ES",
				entityId : "27539733",
				checkinDate : new Date(),
				checkoutDate : new Date(),
				guests : "2",
				rooms : "1",
				pageSize : "1",
				imageLimit : "3"};

		vm.submit = function(){
 	        
	        var res = $http.post('http://localhost:8080/easytripAPI/rest/hotels', JSON.stringify(vm.formData));
			
			res.success(function(data, status, headers, config) {
				vm.hotelsData = data;
			});

			res.error(function(data, status, headers, config) {
				console.log("AJAX failed to get data, status=" + status);
      		});
		}
	}]);