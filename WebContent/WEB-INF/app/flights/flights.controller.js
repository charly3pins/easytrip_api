angular
	.module('easytripAPI')
	.controller('FlightsController', [ '$http', function($http, productsService) {
		var vm = this;

		vm.outbounddate =  new Date();

		vm.submit = function(){
			$http.get('http://localhost:8080/easytripAPI/rest/flights/BCN/ROM')
			.success(function(data){
				vm.flights = data;
				console.log("Results " + vm.flights);
	    	})
	    	.error(function(data, status, headers, config) {
      			console.log("AJAX failed to get data, status=" + status);
      		});
		}
	}]);