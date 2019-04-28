package users.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import users.model.*;
import users.service.*;

import java.util.ArrayList;
import java.util.List;


@Controller
public class UserController {

    private FaceService faceService;
    private EyesService eyesService;
    private BasketService basketService;
    private TypeService typeService;
    private UserService userService;
    private LipsService lipsService;
    private BrowsService browsService;
    private CareService careService;
    private AntiageService antiageService;
    private CleanService cleanService;
    private ContactService contactService;


    private int idTh;
    private int priceTh;
    private String thisLogin = "null";
    private int thisLoginId = 0;


    @Autowired(required = true)
    @Qualifier(value = "faceService")
    public void setFaceService(FaceService faceService) {
        this.faceService = faceService;
    }

    @Autowired(required = true)
    @Qualifier(value = "eyesService")
    public void setEyesService(EyesService eyesService) {
        this.eyesService = eyesService;
    }

    @Autowired(required = true)
    @Qualifier(value = "basketService")
    public void setBasketService(BasketService basketService) {
        this.basketService = basketService;
    }

    @Autowired(required = true)
    @Qualifier(value = "typeService")
    public void setTypeService(TypeService typeService) {
        this.typeService = typeService;
    }

    @Autowired(required = true)
    @Qualifier(value = "userService")
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired(required = true)
    @Qualifier(value = "lipsService")
    public void setLipsService(LipsService lipsService) {
        this.lipsService = lipsService;
    }

    @Autowired(required = true)
    @Qualifier(value = "browsService")
    public void setBrowsService(BrowsService browsService) {
        this.browsService = browsService;
    }

    @Autowired(required = true)
    @Qualifier(value = "careService")
    public void setCareService(CareService careService) {
        this.careService = careService;
    }

    @Autowired(required = true)
    @Qualifier(value = "antiageService")
    public void setAntiageService(AntiageService antiageService) {
        this.antiageService = antiageService;
    }

    @Autowired(required = true)
    @Qualifier(value = "cleanService")
    public void setCleanService(CleanService cleanService) {
        this.cleanService = cleanService;
    }

    @Autowired(required = true)
    @Qualifier(value = "contactService")
    public void setContactService(ContactService contactService) {
        this.contactService = contactService;
    }

    //////////////////////////
    //Лицо

    //Просмотр всего для лица
    @RequestMapping(value = "facePage", method = RequestMethod.GET)
    public String listFace(Model model) {
        model.addAttribute("face", new Face());
        model.addAttribute("listFace", this.faceService.listFace());

        return "facePage";
    }

    //Поиск товара по бренду
    @RequestMapping(value = "/find", method = RequestMethod.POST)
    public String findFaceByBrand(@ModelAttribute("face") Face face, Model model) {
        model.addAttribute("face", new Face());
        model.addAttribute("listFace", this.faceService.findFaceByName(face.getBrand()));
        return "facePage";
    }

    //Сортировка по цене
    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public String listFaceOrder(@ModelAttribute("face") Face face, @RequestParam String val, Model model) {
        model.addAttribute("face", new Face());
        if (val.equals("asc"))
            model.addAttribute("listFace", this.faceService.listFaceOrderAsc());
        else
            model.addAttribute("listFace", this.faceService.listFaceOrderDesc());
        return "facePage";
    }


    //Поиск товара по цене
    @RequestMapping(value = "/findPrice", method = RequestMethod.POST)
    public String findFaceByPrice(@ModelAttribute("face") Face face, Model model) {
        model.addAttribute("face", new Face());
        model.addAttribute("listFace", this.faceService.getFaceByPrice(face.getPrice()));

        return "facePage";
    }

    ///////////////////////////////////////
    //Страничка товара

    //Просмотр выбранного для лица
    @RequestMapping(value = "singleFace", method = RequestMethod.GET)
    public String listSingleFace(Model model) {
        model.addAttribute("basket", new Basket());
        model.addAttribute("face", new Face());
        model.addAttribute("listFace", this.faceService.listFace());
        return "singleFace";
    }

    //Быстрый просмотр для лица
    @RequestMapping("singleFace/{id}")
    public String faceData(@PathVariable("id") int id, Model model) {
        model.addAttribute("face", this.faceService.getFaceById(id));
        model.addAttribute("basket", new Basket());

        idTh = id;
        return "singleFace";
    }

    //Добавление в корзину
    @RequestMapping(value = "singleFace/add", method = RequestMethod.POST)
    public String addBasket(@ModelAttribute("basket") Basket basket) {

        int k = 0;
        List<Type> listType = this.typeService.listType();
        List<User> listUser = this.userService.listUser();
        for (User us : listUser) {
            if (us.getUsername().equals(thisLogin)) {
                basket.setUsername(us.getId());
                thisLoginId = us.getId();
                basket.setType(listType.get(0).getId());
                basket.setIdThing(idTh);
                this.basketService.addBasket(basket);
                k++;
            }

        }
        if (k == 0) {
            return "redirect:/signin";
        } else
            return "redirect:/facePage";
    }


    ////////////////////////////////////////


    ////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Просмотр всего для губ
    @RequestMapping(value = "lipsPage", method = RequestMethod.GET)
    public String listLips(Model model) {
        model.addAttribute("lips", new Lips());
        model.addAttribute("listLips", this.lipsService.listLips());

        return "lipsPage";
    }

    //Поиск губ по бренду
    @RequestMapping(value = "/findLips", method = RequestMethod.POST)
    public String findLipsByBrand(@ModelAttribute("lips") Lips lips, Model model) {
        model.addAttribute("lips", new Lips());
        model.addAttribute("listLips", this.lipsService.findLipsByName(lips.getBrand()));
        return "lipsPage";
    }

    //Сортировка по цене
    @RequestMapping(value = "/orderLips", method = RequestMethod.POST)
    public String listLipsOrder(@ModelAttribute("lips") Lips face, @RequestParam String val, Model model) {


        model.addAttribute("lips", new Lips());
        if (val.equals("asc"))
            model.addAttribute("listLips", this.lipsService.listLipsOrderAsc());
        else
            model.addAttribute("listLips", this.lipsService.listLipsOrderDesc());
        return "lipsPage";
    }


    //Поиск товара по цене
    @RequestMapping(value = "/findPriceLips", method = RequestMethod.POST)
    public String findFaceByPrice(@ModelAttribute("lips") Lips lips, Model model) {
        model.addAttribute("lips", new Lips());
        model.addAttribute("listLips", this.lipsService.getLipsByPrice(lips.getPrice()));

        return "lipsPage";
    }


    ///////////////////////////////////////
    //Страничка товара

    //Просмотр выбранного для губ
    @RequestMapping(value = "singleLips", method = RequestMethod.GET)
    public String listSingleLips(Model model) {
        model.addAttribute("basket", new Basket());
        model.addAttribute("lips", new Lips());
        model.addAttribute("listLips", this.lipsService.listLips());
        return "singleLips";
    }

    //Быстрый просмотр для губ
    @RequestMapping("singleLips/{id}")
    public String lipsData(@PathVariable("id") int id, Model model) {
        model.addAttribute("lips", this.lipsService.getLipsById(id));
        model.addAttribute("basket", new Basket());

        idTh = id;
        return "singleLips";
    }

    //Добавление в корзину
    @RequestMapping(value = "singleLips/add", method = RequestMethod.POST)
    public String addLips(@ModelAttribute("basket") Basket basket) {

        int k = 0;
        List<Type> listType = this.typeService.listType();
        List<User> listUser = this.userService.listUser();
        for (User us : listUser) {
            if (us.getUsername().equals(thisLogin)) {
                basket.setUsername(us.getId());
                thisLoginId = us.getId();
                basket.setType(listType.get(2).getId());
                basket.setIdThing(idTh);
                this.basketService.addBasket(basket);
                k++;
            }

        }
        if (k == 0) {
            return "redirect:/signin";
        } else
            return "redirect:/lipsPage";
    }


    ///////////////////////////////////////


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    ////////////////////////////////////////
    //Глаза

    //Просмотр всего для глаз
    @RequestMapping(value = "eyesPage", method = RequestMethod.GET)
    public String listEyes(Model model) {
        model.addAttribute("eyes", new Eyes());
        model.addAttribute("listEyes", this.eyesService.listEyes());

        return "eyesPage";
    }


    //Быстрый просмотр глаза
    @RequestMapping("singleEyes/{id}")
    public String eyesData(@PathVariable("id") int id, Model model) {
        model.addAttribute("eyes", this.eyesService.getEyesById(id));
        model.addAttribute("basket", new Basket());

        idTh = id;

        return "singleEyes";
    }



    //Поиск товара по бренду
    @RequestMapping(value = "/findEyes", method = RequestMethod.POST)
    public String findFaceByBrand(@ModelAttribute("eyes") Eyes eyes, Model model) {
        model.addAttribute("eyes", new Eyes());
        model.addAttribute("listEyes", this.eyesService.findEyesByName(eyes.getBrand()));
        return "eyesPage";
    }

    //Сортировка по цене
    @RequestMapping(value = "/orderEyes", method = RequestMethod.POST)
    public String listEyesOrder(@ModelAttribute("eyes") Eyes eyes, @RequestParam String val, Model model) {
        model.addAttribute("eyes", new Eyes());
        if (val.equals("asc"))
            model.addAttribute("listEyes", this.eyesService.listEyesOrderAsc());
        else
            model.addAttribute("listEyes", this.eyesService.listEyesOrderDesc());
        return "eyesPage";
    }


    //Поиск товара по цене
    @RequestMapping(value = "/findPriceEyes", method = RequestMethod.POST)
    public String findEyesByPrice(@ModelAttribute("eyes") Eyes eyes, Model model) {
        model.addAttribute("eyes", new Eyes());
        model.addAttribute("listEyes", this.eyesService.getEyesByPrice(eyes.getPrice()));

        return "eyesPage";
    }

    ///////////////////////////////////////
    //Страничка товара

    //Просмотр выбранного для глаз
    @RequestMapping(value = "singleEyes", method = RequestMethod.GET)
    public String listSingleEyes(Model model) {
        model.addAttribute("basket", new Basket());
        model.addAttribute("eyes", new Eyes());
        model.addAttribute("listEyes", this.eyesService.listEyes());
        return "singleEyes";
    }


    //Добавление в корзину
    @RequestMapping(value = "singleEyes/add", method = RequestMethod.POST)
    public String addEyes(@ModelAttribute("basket") Basket basket) {

        int k = 0;
        List<Type> listType = this.typeService.listType();
        List<User> listUser = this.userService.listUser();
        for (User us : listUser) {
            if (us.getUsername().equals(thisLogin)) {
                basket.setUsername(us.getId());
                thisLoginId = us.getId();
                basket.setType(listType.get(1).getId());
                basket.setIdThing(idTh);
                this.basketService.addBasket(basket);
                k++;
            }

        }
        if (k == 0) {
            return "redirect:/signin";
        } else
            return "redirect:/eyesPage";
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////
    //Брови

    //Просмотр всего для бровей
    @RequestMapping(value = "browsPage", method = RequestMethod.GET)
    public String listBrows(Model model) {
        model.addAttribute("brows", new Brows());
        model.addAttribute("listBrows", this.browsService.listBrows());

        return "browsPage";
    }

    //Поиск товара по бренду
    @RequestMapping(value = "/findBrows", method = RequestMethod.POST)
    public String findBrowsByBrand(@ModelAttribute("brows") Brows brows, Model model) {
        model.addAttribute("brows", new Brows());
        model.addAttribute("listBrows", this.browsService.findBrowsByName(brows.getBrand()));
        return "browsPage";
    }

    //Сортировка по цене
    @RequestMapping(value = "/orderBrows", method = RequestMethod.POST)
    public String listBrowsOrder(@ModelAttribute("brows") Brows brows, @RequestParam String val, Model model) {
        model.addAttribute("brows", new Brows());
        if (val.equals("asc"))
            model.addAttribute("listBrows", this.browsService.listBrowsOrderAsc());
        else
            model.addAttribute("listBrows", this.browsService.listBrowsOrderDesc());
        return "browsPage";
    }


    //Поиск товара по цене
    @RequestMapping(value = "/findPriceBrows", method = RequestMethod.POST)
    public String findBrowsByPrice(@ModelAttribute("brows") Brows brows, Model model) {
        model.addAttribute("brows", new Brows());
        model.addAttribute("listBrows", this.browsService.getBrowsByPrice(brows.getPrice()));

        return "browsPage";
    }

    ///////////////////////////////////////
    //Страничка товара

    //Просмотр выбранного товара для бровей
    @RequestMapping(value = "singleBrows", method = RequestMethod.GET)
    public String listSingleBrows(Model model) {
        model.addAttribute("basket", new Basket());
        model.addAttribute("brows", new Brows());
        model.addAttribute("listBrows", this.browsService.listBrows());
        return "singleBrows";
    }

    //Быстрый просмотр для бровей
    @RequestMapping("singleBrows/{id}")
    public String икщцыData(@PathVariable("id") int id, Model model) {
        model.addAttribute("brows", this.browsService.getBrowsById(id));
        model.addAttribute("basket", new Basket());

        idTh = id;
        return "singleBrows";
    }

    //Добавление в корзину
    @RequestMapping(value = "singleBrows/add", method = RequestMethod.POST)
    public String addBrows(@ModelAttribute("basket") Basket basket) {

        int k = 0;
        List<Type> listType = this.typeService.listType();
        List<User> listUser = this.userService.listUser();
        for (User us : listUser) {
            if (us.getUsername().equals(thisLogin)) {
                basket.setUsername(us.getId());
                thisLoginId = us.getId();
                basket.setType(listType.get(3).getId());
                basket.setIdThing(idTh);
                this.basketService.addBasket(basket);
                k++;
            }

        }
        if (k == 0) {
            return "redirect:/signin";
        } else
            return "redirect:/browsPage";
    }


    ////////////////////////////////////////


    ////////////////////////////////////////////////////////////////////////////////////////////////////////


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////
    //Очищение

    //Просмотр всего для очищение
    @RequestMapping(value = "cleanPage", method = RequestMethod.GET)
    public String listClean(Model model) {
        model.addAttribute("clean", new Clean());
        model.addAttribute("listClean", this.cleanService.listClean());

        return "cleanPage";
    }

    //Поиск товара по бренду
    @RequestMapping(value = "/findClean", method = RequestMethod.POST)
    public String findCleanByBrand(@ModelAttribute("clean") Clean clean, Model model) {
        model.addAttribute("clean", new Clean());
        model.addAttribute("listClean", this.cleanService.findCleanByName(clean.getBrand()));
        return "cleanPage";
    }

    //Сортировка по цене
    @RequestMapping(value = "/orderClean", method = RequestMethod.POST)
    public String listCleanOrder(@ModelAttribute("clean") Clean clean, @RequestParam String val, Model model) {
        model.addAttribute("clean", new Clean());
        if (val.equals("asc"))
            model.addAttribute("listClean", this.cleanService.listCleanOrderAsc());
        else
            model.addAttribute("listClean", this.cleanService.listCleanOrderDesc());
        return "cleanPage";
    }


    //Поиск товара по цене
    @RequestMapping(value = "/findPriceClean", method = RequestMethod.POST)
    public String findCleanByPrice(@ModelAttribute("clean") Clean clean, Model model) {
        model.addAttribute("clean", new Clean());
        model.addAttribute("listClean", this.cleanService.getCleanByPrice(clean.getPrice()));

        return "cleanPage";
    }

    ///////////////////////////////////////
    //Страничка товара

    //Просмотр выбранного товара для чистки лица
    @RequestMapping(value = "singleClean", method = RequestMethod.GET)
    public String listSingleClean(Model model) {
        model.addAttribute("basket", new Basket());
        model.addAttribute("clean", new Clean());
        model.addAttribute("listClean", this.cleanService.listClean());
        return "singleClean";
    }

    //Быстрый просмотр товара для чистки лица
    @RequestMapping("singleClean/{id}")
    public String cleanData(@PathVariable("id") int id, Model model) {
        model.addAttribute("clean", this.cleanService.getCleanById(id));
        model.addAttribute("basket", new Basket());

        idTh = id;
        return "singleClean";
    }

    //Добавление в корзину
    @RequestMapping(value = "singleClean/add", method = RequestMethod.POST)
    public String addClean(@ModelAttribute("basket") Basket basket) {

        int k = 0;
        List<Type> listType = this.typeService.listType();
        List<User> listUser = this.userService.listUser();
        for (User us : listUser) {
            if (us.getUsername().equals(thisLogin)) {
                basket.setUsername(us.getId());
                thisLoginId = us.getId();
                basket.setType(listType.get(4).getId());
                basket.setIdThing(idTh);
                this.basketService.addBasket(basket);
                k++;
            }

        }
        if (k == 0) {
            return "redirect:/signin";
        } else
            return "redirect:/cleanPage";
    }


    ////////////////////////////////////////


    ////////////////////////////////////////////////////////////////////////////////////////////////////////


    //////////////////////////
    //Антивозрастной

    //Просмотр всех антивозрастных товаров
    @RequestMapping(value = "antiagePage", method = RequestMethod.GET)
    public String listAntiage(Model model) {
        model.addAttribute("antiage", new Antiage());
        model.addAttribute("listAntiage", this.antiageService.listAntiage());

        return "antiagePage";
    }

    //Поиск товара по бренду
    @RequestMapping(value = "/findAntiage", method = RequestMethod.POST)
    public String findAntiageByBrand(@ModelAttribute("antiage") Antiage antiage, Model model) {
        model.addAttribute("antiage", new Antiage());
        model.addAttribute("listAntiage", this.antiageService.findAntiageByName(antiage.getBrand()));
        return "antiagePage";
    }

    //Сортировка по цене
    @RequestMapping(value = "/orderAntiage", method = RequestMethod.POST)
    public String listAntiageOrder(@ModelAttribute("antiage") Antiage antiage, @RequestParam String val, Model model) {
        model.addAttribute("antiage", new Antiage());
        if (val.equals("asc"))
            model.addAttribute("listAntiage", this.antiageService.listAntiageOrderAsc());
        else
            model.addAttribute("listAntiage", this.antiageService.listAntiageOrderDesc());
        return "antiagePage";
    }


    //Поиск товара по цене
    @RequestMapping(value = "/findPriceAntiage", method = RequestMethod.POST)
    public String findAntiageByPrice(@ModelAttribute("antiage") Antiage antiage, Model model) {
        model.addAttribute("antiage", new Antiage());
        model.addAttribute("listAntiage", this.antiageService.getAntiageByPrice(antiage.getPrice()));

        return "antiagePage";
    }

    ///////////////////////////////////////
    //Страничка товара

    //Просмотр выбранной антивозрастной косметики
    @RequestMapping(value = "singleAntiage", method = RequestMethod.GET)
    public String listSingleAntiage(Model model) {
        model.addAttribute("basket", new Basket());
        model.addAttribute("antiage", new Antiage());
        model.addAttribute("listAntiage", this.antiageService.listAntiage());
        return "singleAntiage";
    }

    //Быстрый просмотр антивозрастной косметики
    @RequestMapping("singleAntiage/{id}")
    public String antiageData(@PathVariable("id") int id, Model model) {
        model.addAttribute("antiage", this.antiageService.getAntiageById(id));
        model.addAttribute("basket", new Basket());

        idTh = id;
        return "singleAntiage";
    }

    //Добавление в корзину
    @RequestMapping(value = "singleAntiage/add", method = RequestMethod.POST)
    public String addBasketAntiage(@ModelAttribute("basket") Basket basket) {

        int k = 0;
        List<Type> listType = this.typeService.listType();
        List<User> listUser = this.userService.listUser();
        for (User us : listUser) {
            if (us.getUsername().equals(thisLogin)) {
                basket.setUsername(us.getId());
                thisLoginId = us.getId();
                basket.setType(listType.get(6).getId());
                basket.setIdThing(idTh);
                this.basketService.addBasket(basket);
                k++;
            }

        }
        if (k == 0) {
            return "redirect:/signin";
        } else
            return "redirect:/antiagePage";
    }


    ////////////////////////////////////////


    ////////////////////////////////////////////////////////////////////////////////////////////////////////


    //////////////////////////////////////
    //////////////////////////////////////
    //Регистрация и авторизация

    //регистрация пользователя
    @RequestMapping(value = "/signin/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user") User user, @RequestParam String val, Model model) {
        int k = 0;
        if (user.getUsername().length() < 7) {
            model.addAttribute("errorLenghtUsername", "Логин должен содержать не менее 8 символов");
            return "signin";
        } else if (user.getPassword().length() < 7) {
            model.addAttribute("errorLenghtPassword", "Пароль должен содержать не менее 8 символов");
            return "signin";
        } else if (user.getPassword().equals(val)) {
            List<User> users = this.userService.listUser();
            for (User userr : users) {
                if (user.getUsername().equals(userr.getUsername()))
                    k++;
            }
            if (k == 0) {
                this.userService.addUser(user);
                thisLogin = user.getUsername();

                if (thisLogin.equals("admin"))
                    return "redirect:/admin";
                else
                    return "redirect:/facePage";
            } else {
                model.addAttribute("errorLogin", "Пользователь с таким логином уже существует");
                return "signin";
            }
        } else {
            model.addAttribute("errorPassword", "Пароль не подтвержден");
            return "signin";
        }
    }


    //авторизация пользователя
    @RequestMapping(value = "/signin/check", method = RequestMethod.POST)
    public String checkUser(@ModelAttribute("user") User user, Model model) {
        int k = 0;
        List<User> users = this.userService.listUser();
        for (User userr : users) {
            if (user.getUsername().equals(userr.getUsername())) {
                k = 1;
                if (user.getPassword().equals(userr.getPassword())) {
                    k = 2;
                }
            }
        }
        if (k == 0) {
            model.addAttribute("errorLoginus", "Неверный логин");
            return "signin";
        } else if (k == 1) {
            model.addAttribute("errorPasswordus", "Неверный пароль");
            return "signin";
        } else {
            thisLogin = user.getUsername();
            if (thisLogin.equals("admin"))
                return "redirect:/admin";
            else
                return "redirect:/facePage";
        }
    }


    //выход из аккаунта
    @RequestMapping(value = "/exit")
    public String exitUser() {
        thisLogin = "null";
        return "redirect:/";
    }

    //////////////////////////
    //Страничка регистрации
    @RequestMapping(value = "signin", method = RequestMethod.GET)
    public String listUsers(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("userFace", this.userService.listUser());

        return "signin";
    }

    //////////////////////////
    //Увлажнение

    //Просмотр всех увлажнялок
    @RequestMapping(value = "carePage", method = RequestMethod.GET)
    public String listCare(Model model) {
        model.addAttribute("care", new Care());
        model.addAttribute("listCare", this.careService.listCare());

        return "carePage";
    }

    //Поиск товара по бренду
    @RequestMapping(value = "/findCare", method = RequestMethod.POST)
    public String findCareByBrand(@ModelAttribute("care") Care care, Model model) {
        model.addAttribute("care", new Care());
        model.addAttribute("listCare", this.careService.findCareByName(care.getBrand()));
        return "carePage";
    }

    //Сортировка по цене
    @RequestMapping(value = "/orderCare", method = RequestMethod.POST)
    public String listCareOrder(@ModelAttribute("care") Care care, @RequestParam String val, Model model) {
        model.addAttribute("care", new Care());
        if (val.equals("asc"))
            model.addAttribute("listCare", this.careService.listCareOrderAsc());
        else
            model.addAttribute("listCare", this.careService.listCareOrderDesc());
        return "carePage";
    }


    //Поиск товара по цене
    @RequestMapping(value = "/findPriceCare", method = RequestMethod.POST)
    public String findCareByPrice(@ModelAttribute("care") Care care, Model model) {
        model.addAttribute("care", new Care());
        model.addAttribute("listCare", this.careService.getCareByPrice(care.getPrice()));

        return "carePage";
    }

    ////////////////////////////////////////////////////////////////////////////
    //Страничка товара

    //Просмотр выбранного увлажняющего товара
    @RequestMapping(value = "singleCare", method = RequestMethod.GET)
    public String listSingleCare(Model model) {
        model.addAttribute("basket", new Basket());
        model.addAttribute("care", new Care());
        model.addAttribute("listCare", this.careService.listCare());
        return "singleCare";
    }

    //Быстрый просмотр увлажнялок
    @RequestMapping("singleCare/{id}")
    public String careData(@PathVariable("id") int id, Model model) {
        model.addAttribute("care", this.careService.getCareById(id));
        model.addAttribute("basket", new Basket());

        idTh = id;
        return "singleCare";
    }

    //Добавление в корзину
    @RequestMapping(value = "singleCare/add", method = RequestMethod.POST)
    public String addBasketCare(@ModelAttribute("basket") Basket basket) {

        int k = 0;
        List<Type> listType = this.typeService.listType();
        List<User> listUser = this.userService.listUser();
        for (User us : listUser) {
            if (us.getUsername().equals(thisLogin)) {
                basket.setUsername(us.getId());
                thisLoginId = us.getId();
                basket.setType(listType.get(5).getId());
                basket.setIdThing(idTh);
                this.basketService.addBasket(basket);
                k++;
            }

        }
        if (k == 0) {
            return "redirect:/signin";
        } else
            return "redirect:/carePage";
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Корзина


    //Просмотреть товары в корзине
    @RequestMapping(value = "basket", method = RequestMethod.GET)
    public String listBasket(Model model) {


        if (thisLogin.equals("null")) {
            return "redirect:/signin";
        } else {

            ArrayList<BasketView> baskView = new ArrayList<BasketView>();
            List<Basket> basket = this.basketService.listBasket();
            List<Type> type = this.typeService.listType();

            for (int i = 0; i < basket.size(); i++) {
                if (basket.get(i).getUsername() == this.userService.getUserByName(thisLogin).getId()) {
                    BasketView bask = new BasketView();
                    bask.setId(basket.get(i).getId());
                    if (basket.get(i).getType() == 1) {
                        bask.setName(this.faceService.getFaceById(basket.get(i).getIdThing()).getName());
                        bask.setPrice(this.faceService.getFaceById(basket.get(i).getIdThing()).getPrice());
                    } else if (basket.get(i).getType() == 2) {
                        bask.setName(this.eyesService.getEyesById(basket.get(i).getIdThing()).getName());
                        bask.setPrice(this.eyesService.getEyesById(basket.get(i).getIdThing()).getPrice());
                    } else if (basket.get(i).getType() == 3) {
                        bask.setName(this.lipsService.getLipsById(basket.get(i).getIdThing()).getName());
                        bask.setPrice(this.lipsService.getLipsById(basket.get(i).getIdThing()).getPrice());
                    } else if (basket.get(i).getType() == 4) {
                        bask.setName(this.browsService.getBrowsById(basket.get(i).getIdThing()).getName());
                        bask.setPrice(this.browsService.getBrowsById(basket.get(i).getIdThing()).getPrice());
                    } else if (basket.get(i).getType() == 5) {
                        bask.setName(this.cleanService.getCleanById(basket.get(i).getIdThing()).getName());
                        bask.setPrice(this.cleanService.getCleanById(basket.get(i).getIdThing()).getPrice());
                    } else if (basket.get(i).getType() == 6) {
                        bask.setName(this.careService.getCareById(basket.get(i).getIdThing()).getName());
                        bask.setPrice(this.careService.getCareById(basket.get(i).getIdThing()).getPrice());
                    } else if (basket.get(i).getType() == 7) {
                        bask.setName(this.antiageService.getAntiageById(basket.get(i).getIdThing()).getName());
                        bask.setPrice(this.antiageService.getAntiageById(basket.get(i).getIdThing()).getPrice());
                    }


                    bask.setType(this.typeService.getTypeById(basket.get(i).getType()).getName());
                    bask.setNameEn(this.typeService.getTypeById(basket.get(i).getType()).getNameEn());
                    bask.setColor(basket.get(i).getColor());
                    bask.setSize(basket.get(i).getSize());
                    baskView.add(bask);
                }
            }

            model.addAttribute("bask", new BasketView());
            model.addAttribute("baskView", baskView);

            return "basket";
        }
    }

    //Изменить состояние товара (купить товар)
    @RequestMapping("edit/{id}")
    public String editUser(@PathVariable("id") int id) {
        this.basketService.updateBasket(id);

        return "redirect:/basket";
    }

    //удалить из карзины
    @RequestMapping("/remove/{id}")
    public String removeUser(@PathVariable("id") int id) {
        this.basketService.removeBasket(id);

        return "redirect:/basket";
    }


    //Отправка сообщения
    @RequestMapping(value = "/addCoantact", method = RequestMethod.POST)
    public String addContact(@ModelAttribute("contact") Contact contact) {
        this.contactService.addContact(contact);
        return "redirect:/contact";
    }

    @RequestMapping(value = "contact", method = RequestMethod.GET)
    public String listContact(Model model) {
        model.addAttribute("contact", new Contact());

        return "contact";
    }


    //Просмотреть заказы
    @RequestMapping(value = "admin", method = RequestMethod.GET)
    public String listAdmin(Model model) {


        if (thisLogin.equals("null")) {
            return "redirect:/signin";
        } else {

            ArrayList<BasketView> baskView = new ArrayList<BasketView>();
            List<Basket> basket = this.basketService.listBasket();
            List<Type> type = this.typeService.listType();

            for (int i = 0; i < basket.size(); i++) {
                BasketView bask = new BasketView();
                bask.setId(basket.get(i).getId());
                if (basket.get(i).getType() == 1) {
                    bask.setName(this.faceService.getFaceById(basket.get(i).getIdThing()).getName());
                    bask.setPrice(this.faceService.getFaceById(basket.get(i).getIdThing()).getPrice());

                } else if (basket.get(i).getType() == 2) {
                    bask.setName(this.eyesService.getEyesById(basket.get(i).getIdThing()).getName());
                    bask.setPrice(this.eyesService.getEyesById(basket.get(i).getIdThing()).getPrice());
                } else if (basket.get(i).getType() == 3) {
                    bask.setName(this.lipsService.getLipsById(basket.get(i).getIdThing()).getName());
                    bask.setPrice(this.lipsService.getLipsById(basket.get(i).getIdThing()).getPrice());
                } else if (basket.get(i).getType() == 4) {
                    bask.setName(this.browsService.getBrowsById(basket.get(i).getIdThing()).getName());
                    bask.setPrice(this.browsService.getBrowsById(basket.get(i).getIdThing()).getPrice());
                } else if (basket.get(i).getType() == 5) {
                    bask.setName(this.cleanService.getCleanById(basket.get(i).getIdThing()).getName());
                    bask.setPrice(this.cleanService.getCleanById(basket.get(i).getIdThing()).getPrice());
                } else if (basket.get(i).getType() == 6) {
                    bask.setName(this.careService.getCareById(basket.get(i).getIdThing()).getName());
                    bask.setPrice(this.careService.getCareById(basket.get(i).getIdThing()).getPrice());
                } else if (basket.get(i).getType() == 7) {
                    bask.setName(this.antiageService.getAntiageById(basket.get(i).getIdThing()).getName());
                    bask.setPrice(this.antiageService.getAntiageById(basket.get(i).getIdThing()).getPrice());
                }


                bask.setType(this.typeService.getTypeById(basket.get(i).getType()).getName());
                bask.setNameEn(this.typeService.getTypeById(basket.get(i).getType()).getNameEn());
                bask.setColor(basket.get(i).getColor());
                bask.setSize(basket.get(i).getSize());
                bask.setUsername(this.userService.getUserById(basket.get(i).getUsername()).getUsername());
                if (basket.get(i).getState() == 1) {
                    bask.setState(basket.get(i).getState());
                    baskView.add(bask);
                }

            }

            model.addAttribute("bask", new BasketView());
            model.addAttribute("baskView", baskView);

            return "admin";
        }
    }


}
