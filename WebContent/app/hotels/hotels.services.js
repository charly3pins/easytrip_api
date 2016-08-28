//angular
//	.module('easytripAPI.hotels')
//	.factory('GetHotelsAutosuggestService', function ($http, $q){
//		return {
//			getHotels: function (str){
//				console.log("getHotels time!");
//				return $http.get("http://localhost:8080/easytripAPI/rest/hotels/getSuggestHotel")
//					.then(function(response){
//						console.log("Respondiendo....");
//						if(typeof response.data === 'object'){
//							return response.data;
//						} else {
//							// invalid response
//							return $q.reject(response.data);
//						}
//					}, 
//					function(response){
//						// something went wrong
//						return $q.reject(response.data);
//					});
//				}
//			};
//		});