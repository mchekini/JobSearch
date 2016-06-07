'use strict';

app.directive('decorate',function()
		{
	return {
		template : '{{annonce.id +"      "+ annonce.titre}}'
	       }
		})