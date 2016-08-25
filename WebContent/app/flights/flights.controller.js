angular
	.module('easytripAPI.flights')
	.controller('FlightsController', [ '$http','$scope', function($http, $scope) {
		$scope.formData = {};
//		$scope.formData = { adults : "1",
//					apiKey : "prtl6749387986743898559646983194",
//					children : "0",
//					country : "ES",
//					currency : "EUR",
//					destPlace :"MAD",
//					groupPricing :true,
//					infants : "0",
//					locale : "es-ES",
//					originPlace : "BCN",
//					outboundDate : new Date(),
//					locationSchema : "iata",
//					cabinClass : "Economy"};
		
		$scope.submit = function(){
		                 	        
	        var res = $http.post('http://localhost:8080/easytripAPI/rest/flights', JSON.stringify(this.formData));
			
			res.success(function(data, status, headers, config) {
				$scope.flightsData = data;
			});

			res.error(function(data, status, headers, config) {
				console.log("AJAX failed to get data, status=" + status);
      		});
		}
		
	}]);