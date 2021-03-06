/*
* MIT License
*
* Copyright (c) 2020 Trevor Flynn
*
* Permission is hereby granted, free of charge, to any person obtaining a copy
* of this software and associated documentation files (the "Software"), to deal
* in the Software without restriction, including without limitation the rights
* to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
* copies of the Software, and to permit persons to whom the Software is
* furnished to do so, subject to the following conditions:
*
* The above copyright notice and this permission notice shall be included in all
* copies or substantial portions of the Software.
*
* THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
* IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
* FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
* AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
* LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
* OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
* SOFTWARE.
*/
package io.tlf.monkeynetty.test.messages;

import io.tlf.monkeynetty.NetworkProtocol;
import io.tlf.monkeynetty.msg.NetworkMessage;

/**
 * @author Radosław K <oxplay.net@gmail.com>
 * 
 * Message used for testing nested Serializable objects within message
 */
public class TestUDPBigMessageB implements NetworkMessage {

    private final TestSerializableDataB objectB;

    public TestUDPBigMessageB() {
        objectB = new TestSerializableDataB();
    }
    
    @Override
    public String getName() {
        return "Test UDP Big Message B";
    }

    @Override
    public NetworkProtocol getProtocol() {
        return NetworkProtocol.UDP;
    }
    
    @Override
    public String toString() {
        return objectB.toString();
    }
}
