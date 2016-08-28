angular
.module('easytripAPI.hotels')
.config(
	function ($routeProvider) {
    	$routeProvider
    		.when('/hotels', {
        		templateUrl: 'app/hotels/views/hotelsv2.html',
        		controller: 'HotelsController',
        		controllerAs: 'hotels'
    		})
			
    		.otherwise({redirectTo: '/'});
	}
);