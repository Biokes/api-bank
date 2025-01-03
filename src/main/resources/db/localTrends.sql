INSERT INTO artist (id, name, type, uri, spotify_url)
VALUES
    ('51DevdOxIJin6DB1FXJpD1', 'UZI', 'artist', 'spotify:artist:51DevdOxIJin6DB1FXJpD1', 'https://open.spotify.com/artist/51DevdOxIJin6DB1FXJpD1'),
    ('3BVPc9s4JXzM6O1InlLxED', 'Mavi', 'artist', 'spotify:artist:3BVPc9s4JXzM6O1InlLxED', 'https://open.spotify.com/artist/3BVPc9s4JXzM6O1InlLxED'),
    ('7GaMopkesD4KK9dNbgyO5D', 'Eko Fresh', 'artist', 'spotify:artist:7GaMopkesD4KK9dNbgyO5D', 'https://open.spotify.com/artist/7GaMopkesD4KK9dNbgyO5D'),
    ('6dOAGo4z0syiCjbnlh4VSO', 'Critical', 'artist', 'spotify:artist:6dOAGo4z0syiCjbnlh4VSO', 'https://open.spotify.com/artist/6dOAGo4z0syiCjbnlh4VSO');

INSERT INTO track (id, name, disc_number, duration_ms, explicit, is_playable, preview_url, track_number, is_local, external_urls_spotify, type, uri)
VALUES
    ('72t3CRd8YEFrlc3x0OVaob', 'Umrumda Değil', 1, 185458, true, true, 'https://p.scdn.co/mp3-preview/ca2df079cdae1386e8b2899951cadf93c335018c?cid=d8a5ed958d274c2e8ee717e6a4b0971d', 2, false, 'https://open.spotify.com/track/72t3CRd8YEFrlc3x0OVaob', 'track', 'spotify:track:72t3CRd8YEFrlc3x0OVaob'),
    ('5TkQatzJqKafPgHQerZ0dL', 'Gecenin İçine Gir', 1, 200000, false, true, 'https://p.scdn.co/mp3-preview/dad0bc5179800da1fe3d5a7c8ca5d9c8563b786b?cid=d8a5ed958d274c2e8ee717e6a4b0971d', 3, false, 'https://open.spotify.com/track/5TkQatzJqKafPgHQerZ0dL', 'track', 'spotify:track:5TkQatzJqKafPgHQerZ0dL'),
    ('6IW5ocUH5DRWagxkLTlbUS', 'Nedenini Sorma', 1, 243205, true, true, 'https://p.scdn.co/mp3-preview/3b60dc4dd3c57960b5e5309f069709034d5e6888?cid=d8a5ed958d274c2e8ee717e6a4b0971d', 4, false, 'https://open.spotify.com/track/6IW5ocUH5DRWagxkLTlbUS', 'track', 'spotify:track:6IW5ocUH5DRWagxkLTlbUS'),
    ('1ijjjMFlM3Pe8t3ykXBzxk', 'Mahalle', 1, 152301, true, true, 'https://p.scdn.co/mp3-preview/355ebff1c469cda6bc280f59cf4546c4a8c0e13a?cid=d8a5ed958d274c2e8ee717e6a4b0971d', 5, false, 'https://open.spotify.com/track/1ijjjMFlM3Pe8t3ykXBzxk', 'track', 'spotify:track:1ijjjMFlM3Pe8t3ykXBzxk'),
    ('4a1WLOoydq7u011UG9jjC9', 'Krvn', 1, 171880, true, true, 'https://p.scdn.co/mp3-preview/c595da41713f76fe3935b4314acda5b4b54a82c2?cid=d8a5ed958d274c2e8ee717e6a4b0971d', 6, false, 'https://open.spotify.com/track/4a1WLOoydq7u011UG9jjC9', 'track', 'spotify:track:4a1WLOoydq7u011UG9jjC9'),
    ('4hy4nY2PiYWx8qVXjpky3P', 'Vur', 1, 155010, true, true, 'https://p.scdn.co/mp3-preview/5b57e9e80e8dc443ad508fa794686e731a3e92ef?cid=d8a5ed958d274c2e8ee717e6a4b0971d', 7, false, 'https://open.spotify.com/track/4hy4nY2PiYWx8qVXjpky3P', 'track', 'spotify:track:4hy4nY2PiYWx8qVXjpky3P'),
    ('4PpYi6USHlY7OhOcDASnD3', 'Davetiye', 1, 223608, true, true, 'https://p.scdn.co/mp3-preview/f162cdd28694f1289d689294a35937d51255e333?cid=d8a5ed958d274c2e8ee717e6a4b0971d', 8, false, 'https://open.spotify.com/track/4PpYi6USHlY7OhOcDASnD3', 'track', 'spotify:track:4PpYi6USHlY7OhOcDASnD3');

INSERT INTO track_artist (track_id, artist_id)
VALUES
    ('72t3CRd8YEFrlc3x0OVaob', '51DevdOxIJin6DB1FXJpD1'),
    ('5TkQatzJqKafPgHQerZ0dL', '51DevdOxIJin6DB1FXJpD1'),
    ('5TkQatzJqKafPgHQerZ0dL', '3BVPc9s4JXzM6O1InlLxED'),
    ('6IW5ocUH5DRWagxkLTlbUS', '51DevdOxIJin6DB1FXJpD1'),
    ('1ijjjMFlM3Pe8t3ykXBzxk', '51DevdOxIJin6DB1FXJpD1'),
    ('1ijjjMFlM3Pe8t3ykXBzxk', '7GaMopkesD4KK9dNbgyO5D'),
    ('4a1WLOoydq7u011UG9jjC9', '51DevdOxIJin6DB1FXJpD1'),
    ('4hy4nY2PiYWx8qVXjpky3P', '51DevdOxIJin6DB1FXJpD1'),
    ('4PpYi6USHlY7OhOcDASnD3', '51DevdOxIJin6DB1FXJpD1'),
    ('4PpYi6USHlY7OhOcDASnD3', '6dOAGo4z0syiCjbnlh4VSO');
