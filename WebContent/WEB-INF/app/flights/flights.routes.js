angular
.module('easytripAPI')
.config(
	function ($routeProvider) {
    	$routeProvider
    		.when('/flights', {
        		templateUrl: 'app/flights/views/flights.html',
        		controller: 'FlightsController',
        		controllerAs: 'flights'
    		})
			.when('/', {
                templateUrl: 'app/home/views/home.html',
                controller: 'HomeController',
                controllerAs: 'home'
            })
			.otherwise({redirectTo: '/'});
	}
);