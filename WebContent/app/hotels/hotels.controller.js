angular
	.module('easytripAPI.hotels')
	.controller('HotelsController', [ '$http', '$q', function($http, $q) {
		var vm = this;

		vm.formData = {};
		vm.formData = {
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
 	        
	        var res = $http.post('http://localhost:8080/easytripAPI/rest/hotels/postHotel', JSON.stringify(vm.formData));
			
			res.success(function(data, status, headers, config) {
				vm.hotelsData = data;
			});

			res.error(function(data, status, headers, config) {
				console.log("AJAX failed to get data, status=" + status);
      		});
		}
		
		vm.searchText = "";
		vm.selectedItem = [];
		vm.searchTextChange = function () {
			console.log("getHotels time!");
			if(vm.searchText.length > 2){
				console.log("buscando: " + vm.searchText);
				return $http.get("http://localhost:8080/easytripAPI/rest/hotels/getSuggestHotel/"+vm.searchText)
					.then(function(response){
						console.log("Respondiendo....");
						if(typeof response.data === 'object'){
							return response.data;
						} else {
							// invalid response
							return $q.reject(response.data);
						}
					}, 
					function(response){
						// something went wrong
						return $q.reject(response.data);
					});
			}
		}
	}]);