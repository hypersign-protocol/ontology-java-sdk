/*
 * Copyright (C) 2018 The ontology Authors
 * This file is part of The ontology library.
 *
 *  The ontology is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Lesser General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  The ontology is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU Lesser General Public License for more details.
 *
 *  You should have received a copy of the GNU Lesser General Public License
 *  along with The ontology.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package com.github.ontio.core;

/**
 *  表示交易特性的用途
 */
public enum TransactionAttributeUsage {

	Nonce(0x00),
    /**
     *  用于对交易进行额外的验证
     */
    Script(0x20),

    DescriptionUrl(0x81),
    Description(0x90),

    ;
    private byte value;

    TransactionAttributeUsage(int v) {
        value = (byte)v;
    }

    public byte value() {
        return value;
    }
    
    public static TransactionAttributeUsage valueOf(byte v) {
    	for (TransactionAttributeUsage e : TransactionAttributeUsage.values()) {
    		if (e.value == v) {
    			return e;
    		}
    	}
    	throw new IllegalArgumentException();
    }
}
