/**
 *  MAHDI CHEKINI
 */

'use strict';

app.service('annonceprovider',function($http)
		{
	this.getannonces = function ()
	{
		$http.get("Offres").
	    success(function(data) {
	    	return cb(data);
	      }).
	      error(function(response) {
	        alert("error");
	      });
		alert("test");
	}
		});