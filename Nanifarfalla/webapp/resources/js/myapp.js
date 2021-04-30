$(function() {

	//solving the active demo problem
	switch (menu) {
		case 'About Us':
			$('#about').addClass('active');
			break;
		case 'Contact Us':
			$('#contact').addClass('active');
			break;
		case 'All Products':
			$('#listProducts').addClass('active');
			break;
		case 'Product Management':
			$('#manageProduct').addClass('active');
			break;
		case 'Shopping Cart':
			$('#userModel').addClass('active');
			break;
		case 'usuario tipo A':
			$('#usuarioa').addClass('active');
			break;
		case 'usuario tipo B':
			$('#usuariob').addClass('active');
			break;
		case 'usuario tipo C':
			$('#usuarioc').addClass('active');
			break;
		default:
			$('#usuarioa').addClass('active');
			if (menu == "Home")
				break;
			$('#listProducts').addClass('active');
			$('#a_' + menu).addClass('active');
			break;


	}


	var products = [

		['1', 'ABC'],
		['2', 'CYX'],
		['3', 'MLC'],
		['4', 'TER'],
		['5', 'ZED'],
		['6', 'LD1'],
		['7', 'EAD'],
		['8', 'A3M'],

	];

	var $table = $('#productListTable');

	//execute the below code only where we have this table 

	if ($table.length) {

		console.log('Inside the table!');




	}



});