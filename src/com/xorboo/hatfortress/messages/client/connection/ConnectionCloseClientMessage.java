package com.xorboo.hatfortress.messages.client.connection;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import org.andengine.extension.multiplayer.protocol.adt.message.client.ClientMessage;

/**
 * (c) 2010 Nicolas Gramlich 
 * (c) 2011 Zynga Inc.
 * 
 * @author Nicolas Gramlich
 * @since 12:00:36 - 21.05.2011
 */
public class ConnectionCloseClientMessage extends ClientMessage implements ClientMessageFlags {
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================
	public int playerID;
	// ===========================================================
	// Constructors
	// ===========================================================

	public ConnectionCloseClientMessage() {
	}

	public ConnectionCloseClientMessage(int id) {
			this.playerID = id;
	}

	// ===========================================================
	// Getter & Setter
	// ===========================================================
	
	public void setPlayerID(final int pID) {
		this.playerID = pID;
	}
	
	// ===========================================================
	// Methods for/from SuperClass/Interfaces
	// ===========================================================

	@Override
	public short getFlag() {
		return FLAG_MESSAGE_CLIENT_CONNECTION_CLOSE;
	}

	@Override
	protected void onReadTransmissionData(final DataInputStream pDataInputStream) throws IOException {
		this.playerID = pDataInputStream.readInt();
	}

	@Override
	protected void onWriteTransmissionData(final DataOutputStream pDataOutputStream) throws IOException {
		pDataOutputStream.writeInt(this.playerID);
	}

	// ===========================================================
	// Methods
	// ===========================================================

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================
}
