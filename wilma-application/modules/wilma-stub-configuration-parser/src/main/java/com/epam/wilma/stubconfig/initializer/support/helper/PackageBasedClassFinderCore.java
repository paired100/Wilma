package com.epam.wilma.stubconfig.initializer.support.helper;
/*==========================================================================
Copyright since 2013, EPAM Systems

This file is part of Wilma.

Wilma is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

Wilma is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with Wilma.  If not, see <http://www.gnu.org/licenses/>.
===========================================================================*/

import java.util.Set;

import org.reflections.Reflections;
import org.reflections.ReflectionsException;
import org.springframework.stereotype.Component;

/**
 * Wrapper around the reflections library.
 * @author Adam_Csaba_Kiraly
 *
 */
@Component
public class PackageBasedClassFinderCore {

    /**
     * Finds the subclasses or interface implementors of the given type and package.
     * @param interfaceOrClass the given type
     * @param packageName the given package
     * @param <T> the type of the {@link Class}
     * @throws ClassNotFoundException in case of error
     * @return the subtypes of the given type that was found
     */
    public <T> Set<Class<? extends T>> find(final String packageName, final Class<T> interfaceOrClass) throws ClassNotFoundException {
        Reflections reflections = new Reflections(packageName);
        Set<Class<? extends T>> subTypes;
        try {
            subTypes = reflections.getSubTypesOf(interfaceOrClass);
        } catch (ReflectionsException e) {
            throw new ClassNotFoundException("Cannot find '" + interfaceOrClass + "' in '" + packageName + "'", e);
        }
        return subTypes;
    }
}
