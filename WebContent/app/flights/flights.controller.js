angular
	.module('easytripAPI.flights')
	.controller('FlightsController', [ '$http', function($http) {
		var vm = this;

		vm.outbounddate =  new Date();

		vm.submit = function(){
			$http.get('http://localhost:8080/easytripAPI/rest/flights/BCN/ROME')
			.success(function(data){
				vm.flightsData = data;
				console.log("Results " + vm.flightsData);
	    	})
	    	.error(function(data, status, headers, config) {
      			console.log("AJAX failed to get data, status=" + status);
      		});
		}
	}]);