/**
 * Copyright 2024 the original author or authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package it.smartcommunitylab.dbsts.jwt;

import java.time.Instant;
import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.Transient;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

@Transient
public class ExpiringJwtAuthenticationToken extends JwtAuthenticationToken {

    private final Instant expiration;

    public ExpiringJwtAuthenticationToken(
        Jwt jwt,
        Collection<? extends GrantedAuthority> authorities,
        Instant expiration
    ) {
        super(jwt, authorities);
        this.setAuthenticated(true);
        this.expiration = expiration;
    }

    public Instant getExpiration() {
        return expiration;
    }
}