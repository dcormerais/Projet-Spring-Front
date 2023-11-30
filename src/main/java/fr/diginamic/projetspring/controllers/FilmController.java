package fr.diginamic.projetspring.controllers;

@RestController
@RequestMapping("/api/films")
public class FilmController {

    private final FilmService filmService;
    private final ActeurService acteurService;
    private final RoleService roleService;

    @Autowired
    public FilmController(FilmService filmService, ActeurService acteurService, RoleService roleService) {
        this.filmService = filmService;
        this.acteurService = acteurService;
        this.roleService = roleService;
    }

    // Opérations CRUD pour les films

    @GetMapping
    public ResponseEntity<List<Film>> getAllFilms() {
        List<Film> films = filmService.getAllFilms();
        return new ResponseEntity<>(films, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Film> getFilmById(@PathVariable Long id) {
        Optional<Film> optionalFilm = filmService.getFilmById(id);
        return optionalFilm.map(film -> new ResponseEntity<>(film, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Film> createFilm(@RequestBody Film film) {
        Film createdFilm = filmService.createFilm(film);
        return new ResponseEntity<>(createdFilm, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Film> updateFilm(@PathVariable Long id, @RequestBody Film film) {
        Optional<Film> optionalUpdatedFilm = filmService.updateFilm(id, film);
        return optionalUpdatedFilm.map(updatedFilm -> new ResponseEntity<>(updatedFilm, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFilm(@PathVariable Long id) {
        filmService.deleteFilm(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Opérations spécifiques

    @GetMapping("/acteur/{acteurId}")
    public ResponseEntity<List<Film>> getFilmsByActeur(@PathVariable Long acteurId) {
        List<Film> films = filmService.getFilmsByActeur(acteurId);
        return new ResponseEntity<>(films, HttpStatus.OK);
    }

    @GetMapping("/roles/{filmId}")
    public ResponseEntity<List<Role>> getRolesByFilm(@PathVariable Long filmId) {
        List<Role> roles = roleService.getRolesByFilm(filmId);
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }

    // Ajoutez d'autres méthodes selon vos besoins
}