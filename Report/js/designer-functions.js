/*****Common toggle******/
var _toggle = $('.js-toggle');
_toggle.each(function () {

    var _this = $(this),
        _target = $(_this.attr('href'));

    _this.on('click', function (e) {
        e.preventDefault();
        _target.toggleClass('visible');
        _this.toggleClass('open');
        _body.toggleClass('is-toggle');
    });
});
/*****End of Toggle***/


/*****Start of Dropdown***/
    var _dropdown = $('.js-dropdownTrigger');
        _dropdown.each(function(){

            var _this = $(this),
                _target = _this.find('.js-dropdownTarget');


                _this.on('click', function(e){
                   e.preventDefault();

                  _target.toggleClass('visible');
                  _this.toggleClass('open');
                  _body.toggleClass('is-dropdown');
                });
        });
       /*****End of Dropdown***/


/******** FUNCTION FOR LIST/GRID VIEW  ****************/
$('.js-change-grid').on('click', function (e) {
    $('.js-change-grid').removeClass("is-active");
    $(this).addClass("is-active");
    if ($(this).hasClass('is-list')) {
        $('.product-listing').removeClass('product-listing-grid').addClass('product-listing-list');
    } else if ($(this).hasClass('is-grid')) {
        $('.product-listing').removeClass('product-listing-list').addClass('product-listing-grid');
    }
});


	var _tab = $('.js-tab');
		_tab.each(function(){

		  var _thisTab = $(this),
			  _tabTrigger = _thisTab.find('a'),
			  _tabTarget = [];

			  _tabTrigger.each(function(){

				var _this = $(this),
					_target = $(_this.attr('href'));

					_tabTarget.push(_target);

					_this.on('click', function(e){
						var _index = _this.parent().index(), _move = 0;
						e.preventDefault();

						for(var i=0; i<_index; i++){_move+=$(_tabTrigger[i]).outerWidth();}

						_tabTrigger.removeClass('current');

						$.each(_tabTarget, function(index, _thisTarget){
						  _thisTarget.removeClass('visible');
						});

						_this.addClass('current');
						_target.addClass('visible');
						_thisTab.animate({
							scrollLeft: Math.max(0, _move)
						}, 800);
						
					});
			  });

		});



/* FOR SEARCH FORM */

$('.js--search--trigger').click(function () {
    $("html").toggleClass("show--search-from");
    return false;
});

$('.common_overlay').click(function () {
    $("html").removeClass("show--search-from");
});



$('.js-share-social').click(function () {
    $(".share--wrap").toggle();
});




/* FOR FOOTER TOGGLES */

if ($(window).width() < 767) {

    $('.js-toggleTrigger').click(function () {
        if ($(this).hasClass('is-active')) {
            $(this).removeClass('is-active');
            $(this).siblings('.js--toggleTarget').slideUp();
            return false;
        }

        $('.js-toggleTrigger').removeClass('is-active');
        $(this).addClass("is-active");
        $('.js--toggleTarget').slideUp();
        $(this).siblings('.js--toggleTarget').slideDown();
    });
}

