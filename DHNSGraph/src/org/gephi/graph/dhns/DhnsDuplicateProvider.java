/*
Copyright 2008-2010 Gephi
Authors : Mathieu Bastian <mathieu.bastian@gephi.org>
Website : http://www.gephi.org

This file is part of Gephi.

Gephi is free software: you can redistribute it and/or modify
it under the terms of the GNU Affero General Public License as
published by the Free Software Foundation, either version 3 of the
License, or (at your option) any later version.

Gephi is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU Affero General Public License for more details.

You should have received a copy of the GNU Affero General Public License
along with Gephi.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.gephi.graph.dhns;

import org.gephi.graph.api.GraphController;
import org.gephi.graph.dhns.core.Dhns;
import org.gephi.project.api.Workspace;
import org.gephi.project.spi.WorkspaceDuplicateProvider;
import org.openide.util.Lookup;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author Mathieu Bastian
 */
@ServiceProvider(service = WorkspaceDuplicateProvider.class, position = 1000)
public class DhnsDuplicateProvider implements WorkspaceDuplicateProvider {

    public void duplicate(Workspace source, Workspace destination) {
        GraphController controller = Lookup.getDefault().lookup(GraphController.class);
        Dhns sourceModel = (Dhns) controller.getModel(source);
        Dhns destModel = (Dhns) controller.getModel(destination);
        if (sourceModel != null && destModel != null) {
            sourceModel.getDuplicateManager().duplicate(destModel);
        }
    }
}
