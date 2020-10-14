<%--
- form.jsp
-
- Copyright (c) 2019 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form readonly="true">
	
	<acme:form-textbox code="supplier.request.form.label.ticker" path="ticker"/>
	<acme:form-textbox code="supplier.request.form.label.creationMoment" path="creationMoment"/>
	<acme:form-textbox code="supplier.request.form.label.quantity" path="quantity"/>
	<acme:form-textbox code="supplier.request.form.label.notes" path="notes"/>
	<acme:form-textbox code="supplier.request.form.label.item.ticker" path="item.ticker"/>
	<acme:form-textbox code="supplier.request.form.label.item.title" path="item.title"/>
	
	
	
	<acme:form-return code="supplier.request.form.button.return"/>
</acme:form>
