/**
 * This file Copyright (c) 2010-2011 Magnolia International
 * Ltd.  (http://www.magnolia-cms.com). All rights reserved.
 *
 *
 * This file is dual-licensed under both the Magnolia
 * Network Agreement and the GNU General Public License.
 * You may elect to use one or the other of these licenses.
 *
 * This file is distributed in the hope that it will be
 * useful, but AS-IS and WITHOUT ANY WARRANTY; without even the
 * implied warranty of MERCHANTABILITY or FITNESS FOR A
 * PARTICULAR PURPOSE, TITLE, or NONINFRINGEMENT.
 * Redistribution, except as permitted by whichever of the GPL
 * or MNA you select, is prohibited.
 *
 * 1. For the GPL license (GPL), you can redistribute and/or
 * modify this file under the terms of the GNU General
 * Public License, Version 3, as published by the Free Software
 * Foundation.  You should have received a copy of the GNU
 * General Public License, Version 3 along with this program;
 * if not, write to the Free Software Foundation, Inc., 51
 * Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * 2. For the Magnolia Network Agreement (MNA), this file
 * and the accompanying materials are made available under the
 * terms of the MNA which accompanies this distribution, and
 * is available at http://www.magnolia-cms.com/mna.html
 *
 * Any modifications to this file must keep this entire header
 * intact.
 *
 */
package info.magnolia.blossom.sample;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import info.magnolia.blossom.sample.service.Customer;
import info.magnolia.blossom.sample.service.Order;
import info.magnolia.blossom.sample.service.OrderRow;
import info.magnolia.blossom.sample.service.SalesApplicationWebService;
import info.magnolia.module.blossom.annotation.Template;

/**
 * Displays a from where the visitor can fill in his address and so on to complete his purchase.
 */
@Controller
@Template(value = "Purchase Form", id = "blossomSample:components/purchase")
public class PurchaseComponent {

    @Autowired
    private SalesApplicationWebService salesApplicationWebService;

    @RequestMapping("/purchase")
    public String handleRequest(@ModelAttribute Customer customer, HttpServletRequest request, HttpSession session) {
        if ("POST".equals(request.getMethod())) {

            ShoppingCart shoppingCart = ShoppingCart.getShoppingCart(session);

            List<OrderRow> rows = new ArrayList<OrderRow>();
            for (ShoppingCartItem cartItem : shoppingCart.getItems()) {
                rows.add(new OrderRow(cartItem.getProduct().getArticleCode(), cartItem.getQuantity()));
            }
            Order order = new Order(customer, rows);

            salesApplicationWebService.placeOrder(order);

            shoppingCart.clear();

            return "components/purchaseFormSubmitted.jsp";
        }
        return "components/purchaseForm.jsp";
    }
}
