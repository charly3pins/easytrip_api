angular
	.module('easytripAPI.hotels')
	.controller('HotelsController', [ '$http', function($http) {
		var vm = this;

		vm.checkindate =  new Date();

		vm.submit = function(){
			$http.get('http://localhost:8080/easytripAPI/rest/hotels/BCN')
			.success(function(data){
				vm.hotelsData = data;
				console.log("Results " + vm.hotelsData);
	    	})
	    	.error(function(data, status, headers, config) {
      			console.log("AJAX failed to get data, status=" + status);
      		});
		}
	}]);