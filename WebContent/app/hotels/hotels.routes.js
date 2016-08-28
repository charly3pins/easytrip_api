angular
.module('easytripAPI.hotels')
.config(
	function ($routeProvider) {
    	$routeProvider
    		.when('/hotels', {
        		templateUrl: 'app/hotels/views/hotels.html',
        		controller: 'HotelsController',
        		controllerAs: 'hotels'
    		})
			
    		.otherwise({redirectTo: '/'});
	}
);