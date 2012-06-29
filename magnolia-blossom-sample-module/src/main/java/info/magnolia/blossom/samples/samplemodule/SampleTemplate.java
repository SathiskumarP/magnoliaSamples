/**
 * This file Copyright (c) 2012 Magnolia International
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
package info.magnolia.blossom.samples.samplemodule;

import javax.jcr.Node;
import javax.jcr.RepositoryException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import info.magnolia.module.blossom.annotation.Area;
import info.magnolia.module.blossom.annotation.AvailableComponentClasses;
import info.magnolia.module.blossom.annotation.TabFactory;
import info.magnolia.module.blossom.annotation.Template;
import info.magnolia.module.blossom.dialog.TabBuilder;

/**
 * Sample template with two columns.
 */
@Controller
@Template(title = "Sample template", id = "blossomModuleSample:pages/sampleTemplate")
public class SampleTemplate {

    /**
     * Left column.
     */
    @Controller
    @Area("left")
    @AvailableComponentClasses({SampleComponent.class})
    public static class LeftArea {

        @TabFactory("Content")
        public void contentTab(TabBuilder tab) {
            tab.addEdit("qwe", "Area", "Area");
        }

        @RequestMapping("/sampleTemplate/left")
        public String render() {
            return "areas/leftArea.jsp";
        }
    }

    /**
     * Right column.
     */
    @Controller
    @Area("right")
    @AvailableComponentClasses({SampleComponent.class})
    public static class RightArea {

        @RequestMapping("/sampleTemplate/right")
        public String render() {
            return "areas/rightArea.jsp";
        }
    }

    @RequestMapping("/sampleTemplate")
    public String render(Node page, ModelMap model) throws RepositoryException {

        model.put("stringFromModel", "This string is supplied by the controller and part of the model");

        return "pages/sampleTemplate.jsp";
    }

    @TabFactory("Properties")
    public void propertiesTab(TabBuilder tab) {
        tab.addEdit("title", "Title", "Title of the page");
        tab.addFckEditor("body", "Body", "Text body");
    }
}
