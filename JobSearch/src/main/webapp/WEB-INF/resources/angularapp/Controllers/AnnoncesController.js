/**
 * 
 */

'use strict';







app
   .controller('lister_annonces',function($scope,annonceprovider)
		   {
	   annonceprovider.getannonces(function(data)
			   {
		   $scope.annonces = data; 
			   })
	  
		   })