angular
	.module('easytripAPI.plans')
	.controller('PlansController', [ '$http', function($http) {
		var vm = this;

		vm.formData = {};
		vm.formData = {
				//latitudeLongitude: "41.396985, 2.148277",
				near : vm.formData.near,
				limit: vm.formData.limit,
				coordenadas : vm.formData.coordenadas,
				section : "sigths",
				categories : vm.searchCategory,
				placeDate : new Date()};
		vm.formData.near = 'Barcelona';
		vm.formData.limit = 10;
		vm.formData.coordenadas = "41.396985, 2.148277";
		vm.items = [];
		vm.item = {};
		vm.item.detalle = {};
		
 	    vm.resultSearchVenues = [];
 	    vm.searchVenue = {};
 	    vm.searchVenue.detalle = {};
 	    
 	    vm.searchCategories = {} ;
 	    
 	    vm.clickOnCheckbox = function() {
 	    	vm.searchCategories = vm.searchCategory;
 	    }
 	    
		vm.explore = function(){
 	    vm.items.detalle = [];
 	    
	        var res = $http.post('http://localhost:8080/easytripAPI/rest/plans/explore', vm.formData);
			
			res.success(function(data, status, headers, config) {
				vm.items = data;
			});

			res.error(function(data, status, headers, config) {
				console.log("AJAX failed to get data, status=" + status);
      		});
		}
		
		vm.search = function(){
	 	    vm.items.detalle = [];
		        var res = $http.post('http://localhost:8080/easytripAPI/rest/plans/search', vm.formData);
				
				res.success(function(data, status, headers, config) {
					vm.resultSearchVenues = data;
				});

				res.error(function(data, status, headers, config) {
					console.log("AJAX failed to get data, status=" + status);
	      		});
			}
		
		vm.venueByIdSearch = function(resultSearchVenue){
 	        
			var index = vm.resultSearchVenues.indexOf(resultSearchVenue);
			var id = resultSearchVenue.id;
			
	        var res = $http.post('http://localhost:8080/easytripAPI/rest/plans/venueById', id);
			
			res.success(function(data, status, headers, config) {
				vm.resultSearchVenues[index].detalle = data;
			});

			res.error(function(data, status, headers, config) {
				console.log("AJAX failed to get data, status=" + status);
      		});
		}
		
		vm.venueById = function(item){
 	        
			var index = vm.items.indexOf(item);
			var id = item.venue.id;
			
	        var res = $http.post('http://localhost:8080/easytripAPI/rest/plans/venueById', id);
			
			res.success(function(data, status, headers, config) {
				vm.items[index].detalle = data;
			});

			res.error(function(data, status, headers, config) {
				console.log("AJAX failed to get data, status=" + status);
      		});
		}
		
			vm.color = {};
	      vm.colors = {Blue: true, Orange: true};

		  
		               
	}]);