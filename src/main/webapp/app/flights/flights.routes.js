angular
.module('easytripAPI.flights')
.config(
	function ($routeProvider) {
    	$routeProvider
    		.when('/flights', {
        		templateUrl: 'app/flights/views/flights.html',
        		controller: 'FlightsController',
        		controllerAs: 'flights'
    		})
			
			.otherwise({redirectTo: '/'});
	}
);