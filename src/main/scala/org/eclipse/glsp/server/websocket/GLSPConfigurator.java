/*******************************************************************************
 * Copyright (c) 2019-2021 EclipseSource and others.
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
 ******************************************************************************/
package org.eclipse.glsp.server.websocket;

import com.google.inject.Injector;
import org.eclipse.jetty.websocket.jsr356.server.ContainerDefaultConfigurator;

import javax.websocket.Extension;
import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;
import javax.websocket.server.ServerEndpointConfig.Configurator;
import java.util.List;
import java.util.ServiceLoader;
import java.util.function.Supplier;

public class GLSPConfigurator extends Configurator {
   protected Configurator containerConfigurator;
   protected final Supplier<Injector> injector;

   public GLSPConfigurator(final Supplier<Injector> injector) {
      this.injector = injector;
   }

   Configurator getContainerConfigurator() {
      if (containerConfigurator == null) {
         ServiceLoader<Configurator> loader = ServiceLoader
            .load(Configurator.class);
         if (loader.iterator().hasNext()) {
            containerConfigurator = loader.iterator().next();
         } else {
            containerConfigurator = new ContainerDefaultConfigurator();
         }
      }
      return containerConfigurator;
   }

   @Override
   public String getNegotiatedSubprotocol(final List<String> supported, final List<String> requested) {
      return this.getContainerConfigurator().getNegotiatedSubprotocol(supported, requested);
   }

   @Override
   public List<Extension> getNegotiatedExtensions(final List<Extension> installed, final List<Extension> requested) {
      return this.getContainerConfigurator().getNegotiatedExtensions(installed, requested);
   }

   @Override
   public boolean checkOrigin(final String originHeaderValue) {
      return this.getContainerConfigurator().checkOrigin(originHeaderValue);
   }

   @Override
   public <T> T getEndpointInstance(final Class<T> endpointClass) throws InstantiationException {
      // This is invoked on each new client connection; so we need a new Injector instance.
      Injector injector = this.injector.get();
      return injector.getInstance(endpointClass);
   }

   @Override
   public void modifyHandshake(final ServerEndpointConfig sec, final HandshakeRequest request,
      final HandshakeResponse response) {
      /* do nothing */
   }
}
