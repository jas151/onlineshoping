/**
 * 
 */

$(function() {
	// solving the active menu problem
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
		if (menu == "Home")
			break;
		$('#home').addClass('active');
		$('listProducts').addClass('active');

		break;
	}

});

/* this is jquerry function to diplay product data into listProduct page */
$(document).ready(
		function() {

			// code for jquerry datatable
			// creatye a dataset

			/*
			 * var products=[ ['1',"ABC"], ['2',"DEF"], ['3',"GHI"],
			 * ['4',"JKL"], ['5',"MNO"], ['6',"PQR"], ['7',"STU"], ['8',"VWX"],
			 * ['9',"YZA"], ['10',"BCD"] ];
			 */

			var $table = $('#productListTable');

			// execute the below code only where we have this table
			if ($table.length) {
				// console.log('Inside the table!');
				var jsonUrl = '';
				if (window.categoryId == '') {
					// alert('working');
					jsonUrl = window.contextRoot + '/json/data/all/products';
				} else {
					jsonUrl = window.contextRoot + '/json/data/category/'
							+ window.categoryId + '/products';
				}
				$table
						.DataTable({
							lengthMenu : [
									[ 3, 5, 10, -1 ],
									[ '3 Records', '5 Records', '10 Records',
											'ALL' ] ],
							pageLength : 5,

							ajax : {
								type : 'GET',
								url : jsonUrl,
								dataType : 'json',
								dataSrc : ''
							},

							columns : [
								{
									data : 'code',
									bSortable : false,
									mRender : function(data, type, row) {

										return '<img src="' + window.contextRoot
												+ '/resources/images/' + data
												+ '.jpg" class="dataTableImg"/>';

									}
								},
								{
									
								data : 'name'
							},
							{
								data : 'brand'
							},
							{
								data : 'unitPrice',
								mRender: function(data,type,row){
									return '&#8377;' + data
								}
							}, 
							{
								data : 'quantity',
								mRender : function(data, type, row) {

									if (data < 1) {
										return '<span style="color:red">Out of Stock!</span>';
									}

									return data;

								}
							},
							{
								data : 'id',
								bSortable: false,
								mRender: function(data, type, row){
									var str= '';
									str += '<a href="'+window.contextRoot+ '/show/'+data+'/product" class="btn btn-primary"><i class="fas fa-eye" style="height: 5px;width: 10px;"></i></a> &#160;' ;
									
									if(row.quantity < 1){
										str += '<a href="javascript:void(0)" class="btn btn-success disabled"><i class="fas fa-shopping-cart" style="height: 5px;width: 10px;"></i></a>';
									}
									else{
										str += '<a href="'+window.contextRoot+ '/cart/add/'+data+'/product" class="btn btn-success"><i class="fas fa-shopping-cart" style="height: 5px;width: 10px;"></i></a>';
									}
									
									//str += '<a href="'+window.contextRoot+ '/cart/add/'+data+'/product" class="btn btn-success"><i class="fas fa-shopping-cart" style="height: 5px;width: 10px;"></i></a>';
								
									return str;	
								}
							}

							]

						});
			}

		});

/*
 * other way to display data in table
 */

/*$(document)
		.ready(
				function() {

					$
							.ajax({
								type : 'GET',
								url : 'http://localhost:2025/onlineshoping/json/data/all/products',
								dataType : 'json',
								success : function(data) {
									var tb_list = '';
									$.each(data, function(key, val) {
										console.log(val.name);
										tb_list += '<tr><td>' + val.id
												+ '</td><td>' + val.name
												+ '</td></tr>';
									});
									$('#productListTable').append(tb_list);
								}
							});

				});*/
