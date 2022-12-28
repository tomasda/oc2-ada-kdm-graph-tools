/********************************************************************************
 * Copyright (c) 2019-2022 EclipseSource and others.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the Eclipse
 * Public License v. 2.0 are satisfied: GNU General Public License, version 2
 * with the GNU Classpath Exception which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 ********************************************************************************/
package com.oc2.diagrams.flowgraph.launch;

import org.apache.commons.cli.ParseException;
import org.eclipse.elk.alg.layered.options.LayeredMetaDataProvider;
import org.eclipse.glsp.layout.ElkLayoutEngine;
import org.eclipse.glsp.server.di.ServerModule;
import org.eclipse.glsp.server.launch.GLSPServerLauncher;
import org.eclipse.glsp.server.launch.SocketGLSPServerLauncher;
import org.eclipse.glsp.server.utils.LaunchUtil;
import org.eclipse.glsp.server.websocket.WebsocketServerLauncher;

import com.oc2.diagrams.commons.launch.CommonCLIParser;
import com.oc2.diagrams.flowgraph.FlowgraphDiagramModule;

public final class FlowgraphServerLauncher {
   private FlowgraphServerLauncher() {}

   @SuppressWarnings("uncommentedmain")
   public static void main(final String[] args) {
      launch(args);
   }

   public static void launch(final String[] args) {
      String processName = "com.oc2.diagrams.flowgraph-X.X.X-glsp.jar";
      try {
         CommonCLIParser parser = new CommonCLIParser(args, processName);
         ElkLayoutEngine.initialize(new LayeredMetaDataProvider());

         int port = parser.parsePort();
         ServerModule flowgraphServerModule = new ServerModule()
            .configureDiagramModule(new FlowgraphDiagramModule());

         GLSPServerLauncher launcher = parser.isWebsocket()
            ? new WebsocketServerLauncher(flowgraphServerModule, "/flowgraph", parser.parseWebsocketLogLevel())
            : new SocketGLSPServerLauncher(flowgraphServerModule);

         launcher.start("localhost", port, parser);

      } catch (ParseException ex) {
         ex.printStackTrace();
         System.out.println();
         LaunchUtil.printHelp(processName, FlowgraphCLIParser.getDefaultOptions());
      }
   }
}
