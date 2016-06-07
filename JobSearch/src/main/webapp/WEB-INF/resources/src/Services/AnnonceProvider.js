'use strict';

var annonces = [
{'id':1,'titre':'developpeur JEE'},
{'id':2,'titre':'developpeur PHP'}
]


app.service('AnnonceProvider',function()
		{
	this.getAnnonces = function()
	{
		return annonces ;
	}
		});