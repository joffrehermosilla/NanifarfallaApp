$(function() {

	//solving the active demo problem
	switch (menu) {

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
			break;

	}






});