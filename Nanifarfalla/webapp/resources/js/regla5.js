$(function() {

	// solving the active menu problem
	switch (menu) {

		case 'Pais':
			$('#pais').addClass('active');
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
		default:
			if (menu == "Home")
				break;
			$('#listProducts').addClass('active');
			$('#a_' + menu).addClass('active');
			break;
	}

});