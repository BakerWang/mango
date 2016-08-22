/*
 * Copyright 2014 mango.jfaster.org
 *
 * The Mango Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package org.jfaster.mango.invoker;

import java.lang.reflect.Type;

/**
 * @author ash
 */
public class UnreachablePropertyException extends InvokerException {

    private Type originalType;

    private Type currentType;

    private String unreachableProperty;

    private String unreachablePropertyPath;

    public UnreachablePropertyException(Type originalType, String unreachableProperty) {
        this(originalType, originalType, unreachableProperty, unreachableProperty);
    }

    public UnreachablePropertyException(Type originalType, Type currentType,
                                        String unreachableProperty, String unreachablePropertyPath) {
        this(buildMsg(originalType, unreachablePropertyPath));
        this.originalType = originalType;
        this.currentType = currentType;
        this.unreachableProperty = unreachableProperty;
        this.unreachablePropertyPath = unreachablePropertyPath;
    }

    public UnreachablePropertyException(String msg) {
        super(msg);
    }

    public UnreachablePropertyException(String msg, Throwable cause) {
        super(msg, cause);
    }

    private static String buildMsg(Type originalType, String unreachablePropertyPath) {
        return "The property '" + unreachablePropertyPath + "' of '" + originalType +
                        "' is unreachable";
    }

    public Type getOriginalType() {
        return originalType;
    }

    public Type getCurrentType() {
        return currentType;
    }

    public String getUnreachableProperty() {
        return unreachableProperty;
    }

    public String getUnreachablePropertyPath() {
        return unreachablePropertyPath;
    }
}