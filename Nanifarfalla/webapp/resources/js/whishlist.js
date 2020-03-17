(function($) {
												jQuery(document)
														.ready(
																function() {
																	'use strict';

																	// this object contains general option for owl carousel instances
																	var defaultOptions = {
																		loop : true,
																		items : 4,
																		dots : false,
																		autoplay : true,
																		margin : 30,
																		autoplayHoverPause : true,
																		slideBy : 1,
																		autoplaySpeed : 4000,
																		autoplayTimeout : 2000,
																		responsive : {
																			0 : {
																				items : 1
																			},
																			350 : {
																				items : 2
																			},
																			480 : {
																				items : 3
																			},
																			600 : {
																				items : 2
																			},
																			768 : {
																				items : 3
																			},
																			978 : {
																				items : 4
																			},
																			1198 : {
																				items : 4
																			}
																		}
																	};

																	/*@param selector is a string name of the selctor that needs to be initialized,
																	 * @param specificOptions object that contains options for specific instance of owlCarousel, pass null
																	 * if no additional option necessary
																	 * @param prevs and next are the control selector for the specific owlcarousel instance
																	 */
																	function owlInit(
																			selector,
																			specificOptions,
																			prev,
																			next) {
																		var specificOptions = specificOptions
																				|| {}, $selector = $(selector);

																		$selector
																				.owlCarousel($
																						.extend(
																								{},
																								defaultOptions,
																								specificOptions));

																		if ((prev != 'undefined' || prev != 'null')
																				|| (next != 'undefined' || next != 'null')) {
																			$(
																					prev)
																					.on(
																							'click',
																							function() {
																								$selector
																										.trigger('prev.owl.carousel');
																							});
																			$(
																					next)
																					.on(
																							'click',
																							function() {
																								$selector
																										.trigger('next.owl.carousel');
																							});
																		}
																	}

																	owlInit(
																			'.atw--slider1827011033',
																			null,
																			'.slider--control1827011033.icon-arrow-left',
																			'.slider--control1827011033.icon-arrow-right');
																});
											})(jQuery)