/**
 * This file Copyright (c) 2010 Magnolia International
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

import info.magnolia.blossom.sample.service.Book;
import info.magnolia.blossom.sample.service.SalesApplicationWebService;
import info.magnolia.cms.core.Content;
import info.magnolia.context.MgnlContext;
import info.magnolia.module.blossom.annotation.Paragraph;
import info.magnolia.module.blossom.annotation.ParagraphDescription;
import info.magnolia.module.blossom.annotation.TabFactory;
import info.magnolia.module.blossom.dialog.TabBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

/**
 * Paragraph that displays information about a book. The book is selected by the editor in a dialog and
 * read from the SalesApplicationWebService at display time.
 */
@Paragraph("Book")
@ParagraphDescription("Description of a book")
@Controller
public class BookParagraph {

    @Autowired
    private SalesApplicationWebService salesApplicationWebService;

    @RequestMapping("/book")
    public String handleRequest(ModelMap model, HttpSession session, HttpServletRequest request) {

        Content content = MgnlContext.getAggregationState().getCurrentContent();

        String articleCode = content.getNodeData("articleCode").getString();

        Book book = salesApplicationWebService.getBook(articleCode);

        if ("add".equals(request.getParameter("action"))) {

            ShoppingCart shoppingCart = ShoppingCart.getShoppingCart(session);

            shoppingCart.addItem(book, Integer.parseInt(request.getParameter("quantity")));

            return "redirect:" + request.getContextPath() + request.getRequestURI();
        }

        model.put("book", book);

        return "book";
    }

    @TabFactory("Content")
    public void contentTab(TabBuilder tab) {
        List<Book> books = salesApplicationWebService.getAllBooks();
        HashMap<String, String> options = new HashMap<String, String>();
        for (Book book : books) {
            options.put(book.getTitle(), book.getArticleCode());
        }
        tab.addSelect("articleCode", "Book", "", options);
    }
}
