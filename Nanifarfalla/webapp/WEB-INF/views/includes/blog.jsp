
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value="${param.lang}" />
<fmt:setBundle basename="messages" />
<html lang="en" xmlns:th="http://www.thymeleaf.org">


<spring:url value="/resources" var="urlPublic" />




<section class="container pt-md-3 pb-5 mb-md-3" style="align-self: center;">


	<div class="page-header">
		<h2 class="text text-center">
			<span class="label label-success">Noticias y novedades</span>
		</h2>
	</div>
	<div class="row">
		<div class="col-sm-12 blog-main">
			<div class="blog-post">
				<h3 class="blog-post-title">Julia Roberts protagonizará The
					Bookseller</h3>
				<p class="blog-post-meta">
					<span class="label label-danger">Publicado: 16-06-2017</span>
				</p>
				<p>
					La novela de Cynthia Swanson <span style="color: #0000ff;"><strong>The
							Bookseller</strong></span> ser&aacute; llevada al cine con <span
						style="color: #0000ff;">Julia Roberts (Los Pitufos: La
						aldea Escondida)</span> como protagonista.<br /> <br />La historia
					est&aacute; ambientada en los sesenta y su protagonista es una
					mujer soltera, Kitty Miller, que lleva una librer&iacute;a.
					Sue&ntilde;a con una vida alternativa en la que ha encontrado el
					amor y est&aacute; casada y con hijos, pero la l&iacute;nea que
					separa realidad y ficci&oacute;n comienza a estar demasiado
					dispersa para que la distinga.<br /> <br />Seg&uacute;n informa <span
						style="color: #ff0000;"><strong>Moviehole</strong></span> Roberts
					tambi&eacute;n producir&aacute; la pel&iacute;cula junto a Lisa
					Gillan y Marisa Yeres Hill.
				</p>
				<hr class="featurette-divider">
			</div>
			<div class="blog-post">
				<h3 class="blog-post-title">Bob Esponja: tercera película y
					temporada 12</h3>
				<p class="blog-post-meta">
					<span class="label label-danger">Publicado: 15-06-2017</span>
				</p>
				<p>
					<strong><span style="color: #ff0000;">Nickelodeon y
							productor de SpongeBob Square Pants confirman temporada 12 de 52
							episodios y tercera pel&iacute;cula pr&oacute;ximamente. </span></strong>
				</p>
				<p>
					<strong>&iexcl;Calamardo est&aacute; enojado!Bob Esponja:
						tercera pel&iacute;cula y temporada 12</strong>
				</p>
				<p>Nickelodeon y productor de SpongeBob Square Pants confirman
					temporada 12 de 52 episodios y tercera pel&iacute;cula
					pr&oacute;ximamente. &iexcl;Calamardo est&aacute; enojado!.</p>
				<p>A lado de cierta Pi&ntilde;a (debajo del mar), Calamardo debe
					estar de muy mal humor, pues hay Bob Esponja para rato... &iexcl;y
					por partida doble!. Por un lado, Vincent Waller (The Ren &amp;
					Stimpy Show), artista, productor, escritor y supervisor creativo de
					SpongeBob Squarepants anunci&oacute; con un divertido dibujo desde
					su cuenta de Twitter que, antes de que se estrene siquiera la
					temporada 11 de la serie animada, se ha confirmado ya la
					n&uacute;mero 12, &iexcl;que constar&aacute; de 52 episodios
					(recuerden que cada emisi&oacute;n consta de 2 aventuras)!</p>

				<hr class="featurette-divider">
			</div>

		</div>
	</div>
</section>