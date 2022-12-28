/********************************************************************************
 * Copyright (c) 2020-2022 EclipseSource and others.
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
package com.oc2.diagrams.commons.launch;

import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.logging.log4j.Level;
import org.eclipse.glsp.server.launch.DefaultCLIParser;

public class CommonCLIParser extends DefaultCLIParser {
   public static final String OPTION_WEBSOCKET = "websocket";
   public static final String OPTION_JETTY_LOG_LEVEL = "jettyLogLevel";

   public static final class FlowgraphOptions {
      public static final Level WEBSOCKET_LOG_LEVEL = Level.INFO;
   }

   public CommonCLIParser(final String[] args, final String processName)
      throws ParseException {
      super(args, CommonCLIParser.getDefaultOptions(), processName);
   }

   public boolean isWebsocket() { return hasOption(OPTION_WEBSOCKET); }

   public Level parseWebsocketLogLevel() {
      String levelArg = parseOption(OPTION_JETTY_LOG_LEVEL, FlowgraphOptions.WEBSOCKET_LOG_LEVEL.toString());
      return Level.toLevel(levelArg, FlowgraphOptions.WEBSOCKET_LOG_LEVEL);
   }

   public static Options getDefaultOptions() {
      Options options = DefaultCLIParser.getDefaultOptions();
      options.addOption("w", OPTION_WEBSOCKET, false,
         "Use websocket launcher instead of default launcher.");
      options.addOption("j", OPTION_JETTY_LOG_LEVEL, true,
         "Set the log level for the Jetty websocket server. [default='INFO']");
      return options;
   }

}
