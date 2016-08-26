angular
.module('easytripAPI.plans')
.config(
	function ($routeProvider) {
    	$routeProvider
    		.when('/plans', {
        		templateUrl: 'app/plans/views/plans.html',
        		controller: 'PlansController',
        		controllerAs: 'plans'
    		})
			
			.otherwise({redirectTo: '/'});
	}
);