angular
	.module('easytripAPI.flights')
	.controller('FlightsController', [ '$http', function($http) {
		var vm = this;

		vm.formData = {};
		vm.formData = {
					adults : "1",
					children : "0",
					country : "ES",
					currency : "EUR",
					destPlace :"DPS",
					groupPricing :true,
					infants : "0",
					locale : "es-ES",
					originPlace : "BCN",
					outboundDate : new Date(),
					inboundDate : new Date(),
					locationSchema : "Iata",
					cabinClass : "Economy"};
		
		vm.submit = function(){
		                 	        
	        var res = $http.post('http://localhost:8080/easytripAPI/rest/flights', vm.formData);
			
			res.success(function(data, status, headers, config) {
				vm.flightsData = data;
			});

			res.error(function(data, status, headers, config) {
				console.log("AJAX failed to get data, status=" + status);
      		});
		}
		
		// LOCATION AUTOSUGGEST ORIGEN
		vm.selectedItemOrigin = [];
		vm.searchTextChangeOrigin = function () {
			if(vm.searchTextOrigin.length > 2){ // a partir de 2 carácteres buscamos en la API
				return $http.get("http://localhost:8080/easytripAPI/rest/suggestLocation/"+vm.searchTextOrigin)
					.then(function(response){
						return response.data;
					}, 
					function(response){
						// something went wrong
						return $q.reject(response.data);
					});
			}
		}
		
		// cuando cambia el valor del autocomplete, entramos aquí para hacer el binding con la property de nuestro formData
		vm.selectedItemChangeOrigin = function () {
		   if(vm.selectedItemOrigin != null){
			   vm.formData.originPlace = vm.selectedItemOrigin.PlaceId;
		   }
		}
		
		// LOCATION AUTOSUGGEST DESTINO
		vm.selectedItemDest = [];
		vm.searchTextChangeDest = function () {
			if(vm.searchTextDest.length > 2){ // a partir de 2 carácteres buscamos en la API
				return $http.get("http://localhost:8080/easytripAPI/rest/suggestLocation/"+vm.searchTextDest)
					.then(function(response){
						return response.data;
					}, 
					function(response){
						// something went wrong
						return $q.reject(response.data);
					});
			}
		}
		
		// cuando cambia el valor del autocomplete, entramos aquí para hacer el binding con la property de nuestro formData
		vm.selectedItemChangeDest = function () {
		   if(vm.selectedItemDest != null){
			   vm.formData.destPlace = vm.selectedItemDest.PlaceId;
		   }
		}
		
	}]);