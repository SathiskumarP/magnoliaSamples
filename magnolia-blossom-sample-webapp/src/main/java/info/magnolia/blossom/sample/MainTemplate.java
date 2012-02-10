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

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import info.magnolia.module.blossom.annotation.Area;
import info.magnolia.module.blossom.annotation.AvailableComponents;
import info.magnolia.module.blossom.annotation.Inherits;
import info.magnolia.module.blossom.annotation.TabFactory;
import info.magnolia.module.blossom.annotation.Template;
import info.magnolia.module.blossom.annotation.TernaryBoolean;
import info.magnolia.module.blossom.dialog.TabBuilder;

/**
 * Template with two columns, a main content area and a right side column.
 */
@Controller
@Template(value = "Two Columns", id = "blossomSample:pages/main")
public class MainTemplate {

    @Area("main")
    @Controller
    public static class MainArea {

        @TabFactory("Content")
        public void apa(TabBuilder tab) {
            tab.addEdit("qwe", "Area", "Area");
        }

        @RequestMapping("/mainTemplate/main")
        public String render() {
            return "areas/main.jsp";
        }
    }

    @Controller
    @Area(value = "promos", title = "Promos", optional = TernaryBoolean.TRUE)
    @Inherits
    @AvailableComponents({"blossomSample:components/text", "blossomSample:components/shoppingCart", "blossomSample:components/bookCategory"})
    public static class PromosArea {

        @RequestMapping("/mainTemplate/promos")
        public String render() {
            return "areas/promos.jsp";
        }
    }

    @RequestMapping("/mainTemplate")
    public String render(ModelMap model) {
        return "pages/main.jsp";
    }

    @TabFactory("Content")
    public void propertiesDialog(TabBuilder tab) {
        tab.addEdit("title", "Title", "");
    }
}
