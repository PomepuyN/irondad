/*
 * This source is part of the
 *      _____  ___   ____
 *  __ / / _ \/ _ | / __/___  _______ _
 * / // / , _/ __ |/ _/_/ _ \/ __/ _ `/
 * \___/_/|_/_/ |_/_/ (_)___/_/  \_, /
 *                              /___/
 * repository.
 *
 * Copyright (C) 2013 Benoit 'BoD' Lubek (BoD@JRAF.org)
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, see
 * <http://www.gnu.org/licenses/>.
 */
package org.jraf.irondad.handler;

import java.util.List;

import org.jraf.irondad.protocol.ClientConfig;
import org.jraf.irondad.protocol.Connection;
import org.jraf.irondad.protocol.Message;

public interface Handler {
    /**
     * Initialize this Handler.<br/>
     * This will be called only once.
     * 
     * @param clientConfig The client config.
     */
    void init(ClientConfig clientConfig) throws Exception;

    /**
     * Initialize this Handler for the given context.<br/>
     * This will be called once per context.
     * 
     * @param clientConfig The client config.
     */
    void init(HandlerContext handlerContext) throws Exception;

    /**
     * @param channel If not {@code null}, the channel on which the message was sent. If {@code null}, this call is a private message.
     */
    boolean isMessageHandled(String channel, String fromNickname, String text, List<String> textAsList, Message message, HandlerContext handlerContext);

    /**
     * @param channel If not {@code null}, the channel on which the message was sent. If {@code null}, this call is a private message.
     */
    void handleMessage(Connection connection, String channel, String fromNickname, String text, List<String> textAsList, Message message,
            HandlerContext handlerContext) throws Exception;
}
