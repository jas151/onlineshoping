/**
 * 
 */

$(function(){
	//solving the active menu problem
	switch (menu) {
	
	case 'About Us':
		alert(menu);
		$('#about').addClass('active');
		break;
		
	case 'Contact Us':
		alert(menu);
		$('#contact').addClass('active');
		break;
	case 'All Products':
		alert(menu);
		$('listProducts').addClass('active');
		break;
	
	default:
		$('#home').addClass('active');
		break;
	}
	
});